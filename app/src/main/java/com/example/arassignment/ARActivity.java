package com.example.arassignment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ARActivity extends AppCompatActivity {
    private ArFragment arFragment;
    private ModelRenderable cubeRenderable;
    private boolean isPlaced = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aractivity);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ar_fragment);
        MaterialFactory.makeOpaqueWithColor(this, new Color(android.graphics.Color.RED))
                .thenAccept(material -> {
                    cubeRenderable = ShapeFactory.makeCube(new Vector3(0.1f, 0.1f, 0.1f),
                            Vector3.zero(), material);
                });
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            if (!isPlaced && cubeRenderable != null) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                TransformableNode cubeNode = new TransformableNode(arFragment.getTransformationSystem());
                cubeNode.setParent(anchorNode);
                cubeNode.setRenderable(cubeRenderable);
                cubeNode.select();
                isPlaced = true;
            }
        });
    }
}