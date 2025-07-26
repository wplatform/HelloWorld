package com.github.azeroth.game.domain.gobject;


import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class QuaternionData {

    public float x, y, z, w;


    public boolean isUnit() {
        return Math.abs(x * x + y * y + z * z + w * w - 1.0f) < 1e-5f;
    }

    public void toEulerAnglesZYX(float z, float y, float x) {
        Quaternion quaternion = new Quaternion(this.x, this.y, this.z, w);
        Matrix4 mat = new Matrix4().setToRotation(new Vector3(x, y, z)).trn( x, y, z );

        quaternion.toMatrix();
    }

    /**
     * ZYX Euler Angles
     * ZYX Euler angles are a common convention used in aerospace engineering to describe orientations in 3D.
     * This page explains what ZYX Euler angles are, how to obtain rotation matrices, how to recover Euler angles
     * from rotation matrices, and some things to be careful when dealing with them. The concepts on this page
     * can be applied to any Euler angles. Example code is provided in Python.
     * <p>
     * Z-Y-X intrinsic rotation Euler angles are defined as follows:
     * <p>
     * 1.Rotate about Z (of the original fixed frame) by ψ (yaw)
     * 2.Rotate about Y of the new frame (frame after rotation in 1.) by θ (pitch)
     * 3.Rotate about X of the new frame (frame after rotation in 2.) by φ (roll)
     * This is the same as X-Y-Z extrinsic rotation:
     * <p>
     * 1.Rotate about X of the original fixed frame by φ (roll)
     * 2.Rotate about Y of the original fixed frame by θ (pitch)
     * 3.Rotate about Z of the original fixed frame by ψ (yaw)
     * <p>
     * It is one of six Tait-Bryan angles because the angles represent
     * @param yaw
     * @param pitch
     * @param roll
     */
    public void setEulerAngles(float yaw, float pitch, float roll) {
        Quaternion quaternion = new Quaternion(this.x, this.y, this.z, this.w);
        quaternion.setEulerAngles(yaw, pitch, roll);
        this.x = quaternion.x;
        this.y = quaternion.y;
        this.z = quaternion.z;
        this.w = quaternion.w;
    }
}
