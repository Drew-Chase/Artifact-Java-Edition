package com.dcman58.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.dcman58.Entity.PlayerSave;
import com.dcman58.Main.GamePanel;

@SuppressWarnings("all")
public class AcidState extends GameState {

	private float hue;
	private Color color;

	private double angle;
	private BufferedImage image;

	public AcidState(GameStateManager gsm) {
		super(gsm);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/PlayerSprites.png")).getSubimage(0, 0, 40, 40);
		} catch (Exception e) {
		}
	}

	public void init() {
	}

	long time = 0;

	public void update() {
		handleInput();
		if (time >= 400) {
			gsm.setState(PlayerSave.LoadLevel());
		} else {
			time++;
		}
		color = Color.getHSBColor(hue, 1f, 1f);
		hue += 0.01;
		if (hue > 1)
			hue = 0;
		angle += 0.1;
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		AffineTransform at = new AffineTransform();
		at.translate(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2);
		at.rotate(angle);
		g.setFont(new Font("Arial", Font.PLAIN, 14));
		g.setColor(Color.BLACK);
		g.drawString("Loading Next Level...", 20, 20);
		g.drawImage(image, at, null);
	}

	public void handleInput() {
	}

}
