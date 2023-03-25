package com.servlets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/verificationCode")
public class CaptchaGenerator extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 40;

        BufferedImage captchaImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = captchaImage.getGraphics();

        // Set captcha border.
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // Set Captcha text font and color.
        Font font = new Font("Arial", Font.BOLD, 25);
        graphics.setFont(font);
        graphics.setColor(Color.BLUE);

        // Set Captcha text.
        Random random = new Random();
        String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder captchaBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            captchaBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        String captchaText = captchaBuilder.toString();;
        graphics.drawString(captchaText, 30, 30);

        // Set Captcha noise.
        for (int i = 0; i < 150; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            graphics.drawOval(x, y, 1, 1);
        }

        // Write captcha image to response output stream.
        response.setContentType("image/png");
        ImageIO.write(captchaImage, "png", response.getOutputStream());

        // Save captcha in session attribute for validation.
        HttpSession session = request.getSession(true);
        session.setAttribute("captcha", captchaText);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
