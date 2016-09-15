package com.mycompany.a3;

public interface ICollider {
	boolean collidesWith(GameObject other);
	void handleCollision(GameObject other, GameWorld gw);

}
