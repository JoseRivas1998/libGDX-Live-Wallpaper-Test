package com.tcg.libgdxwallpaper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x, y, width, height;

	Vector2 velocity;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Gdx.app.log(getClass().getName(), "create");
		x = 0;
		y = 0;
		width = img.getWidth();
		height = img.getHeight();
		float speed = 500;
		float radians = MathUtils.random(MathUtils.PI2);
		velocity = new Vector2();
		velocity.x = MathUtils.cos(radians) * speed;
		velocity.y = MathUtils.sin(radians) * speed;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float dt = Gdx.graphics.getDeltaTime();

		if(x < 0 || x > Gdx.graphics.getWidth() - width) {
		    velocity.x *= -1;
        }
        if(y < 0 || y > Gdx.graphics.getHeight() - height) {
		    velocity.y *= -1;
        }

		x += velocity.x * dt;
		y += velocity.y * dt;

		if(Gdx.input.isTouched()) {
		    x = Gdx.input.getX(0) - (width * .5f);
		    y = Gdx.graphics.getHeight() - Gdx.input.getY(0) - (height * .5f);
            float speed = 500;
            float radians = MathUtils.random(MathUtils.PI2);
            velocity = new Vector2();
            velocity.x = MathUtils.cos(radians) * speed;
            velocity.y = MathUtils.sin(radians) * speed;
        }

		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
