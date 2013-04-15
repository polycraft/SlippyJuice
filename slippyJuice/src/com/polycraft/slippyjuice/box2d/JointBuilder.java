package com.polycraft.slippyjuice.box2d;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

public class JointBuilder {

	public class DistanceJointBuilder {

		private DistanceJointDef distanceJointDef;

		private void reset() {
			distanceJointDef = new DistanceJointDef();
		}

		public DistanceJointBuilder bodyA(Body bodyA) {
			distanceJointDef.bodyA = bodyA;
			return this;
		}

		public DistanceJointBuilder bodyB(Body bodyB) {
			distanceJointDef.bodyB = bodyB;
			return this;
		}

		public DistanceJointBuilder collideConnected(boolean collideConnected) {
			distanceJointDef.collideConnected = collideConnected;
			return this;
		}

		public DistanceJointBuilder length(float length) {
			distanceJointDef.length = length;
			return this;
		}

		public Joint build() {
			return world.createJoint(distanceJointDef);
		}

	}

	public class RevoluteJointBuilder {

		private RevoluteJointDef revoluteJointDef;

		private void reset() {
			revoluteJointDef = new RevoluteJointDef();
		}

		public RevoluteJointBuilder bodyA(Body bodyA, float x, float y) {
			revoluteJointDef.bodyA = bodyA;
			revoluteJointDef.localAnchorA.set(x, y);
			return this;
		}

		public RevoluteJointBuilder bodyB(Body bodyB, float x, float y) {
			revoluteJointDef.bodyB = bodyB;
			revoluteJointDef.localAnchorB.set(x, y);
			return this;
		}

		public RevoluteJointBuilder collideConnected(boolean collideConnected) {
			revoluteJointDef.collideConnected = collideConnected;
			return this;
		}

		public RevoluteJointBuilder enableMotor(float speed) {
			enableMotor(speed, revoluteJointDef.maxMotorTorque);
			return this;
		}

		/**
		 * @param enableMotor
		 * @param speed
		 *            radian/sec
		 * @param maxTorque
		 * @return
		 */
		public RevoluteJointBuilder enableMotor(float speed, float maxTorque) {
			revoluteJointDef.enableMotor = true;
			revoluteJointDef.motorSpeed = speed;
			revoluteJointDef.maxMotorTorque = maxTorque;
			return this;
		}

		/**
		 * @param enableLimit
		 * @param lower
		 * @param upper
		 * @return
		 */
		public RevoluteJointBuilder enableLimit(boolean enableLimit,
				float lower, float upper) {
			revoluteJointDef.enableLimit = enableLimit;
			revoluteJointDef.lowerAngle = lower;
			revoluteJointDef.upperAngle = upper;
			return this;
		}

		public Joint build() {
			return world.createJoint(revoluteJointDef);
		}

	}

	private final World world;
	private DistanceJointBuilder distanceJointBuilder;
	private RevoluteJointBuilder revoluteJointBuilder;

	public JointBuilder(World world) {
		this.world = world;
		this.distanceJointBuilder = new DistanceJointBuilder();
		this.revoluteJointBuilder = new RevoluteJointBuilder();
	}

	public DistanceJointBuilder distanceJoint() {
		distanceJointBuilder.reset();
		return distanceJointBuilder;
	}

	public RevoluteJointBuilder revoluteJoint() {
		revoluteJointBuilder.reset();
		return revoluteJointBuilder;
	}

}
