package com.antsject.antsplusantsequalschaos.client;

import java.util.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.core.Direction;
import org.joml.Vector3f;

public final class RedAntGeometry {

    private RedAntGeometry() {}

    public static ModelPart create() {
        ModelPart p0 = part(List.of(cube(new float[]{-2.75f, -1.0f, -5.0f, 2.75f, 3.0f, 0.0f}, new float[]{1.0f, 1.0f, 7.0f, 5.0f, 9.0f, 1.0f, 14.0f, 5.0f, 16.0f, 1.0f, 22.0f, 5.0f, 24.0f, 1.0f, 29.0f, 5.0f, 31.0f, 1.0f, 37.0f, 6.0f, 39.0f, 1.0f, 45.0f, 6.0f})), new LinkedHashMap<>(), 0.0f, 1.0f, 3.0f, -0.436332313f, 0.0f, 0.0f);
        ModelPart p1 = part(List.of(cube(new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}, new float[]{47.0f, 1.0f, 49.0f, 3.0f, 51.0f, 1.0f, 53.0f, 3.0f, 55.0f, 1.0f, 57.0f, 3.0f, 59.0f, 1.0f, 61.0f, 3.0f, 63.0f, 1.0f, 65.0f, 3.0f, 67.0f, 1.0f, 69.0f, 3.0f})), new LinkedHashMap<>(), 0.0f, 0.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p2 = part(List.of(cube(new float[]{-3.75f, -2.4375f, -3.5f, 3.75f, 2.4375f, 3.5f}, new float[]{11.0f, 11.0f, 19.0f, 16.0f, 21.0f, 11.0f, 28.0f, 16.0f, 30.0f, 11.0f, 38.0f, 16.0f, 40.0f, 11.0f, 47.0f, 16.0f, 49.0f, 11.0f, 57.0f, 18.0f, 59.0f, 11.0f, 67.0f, 18.0f})), new LinkedHashMap<>(), 0.0f, 0.0f, -3.5f, 0.0f, 0.0f, 0.0f);
        ModelPart p3 = part(List.of(cube(new float[]{-0.9375f, -0.8125f, -0.025f, 0.9375f, 0.8125f, 0.025f}, new float[]{2.0f, 64.0f, 6.0f, 68.0f, 8.0f, 64.0f, 12.0f, 68.0f, 14.0f, 64.0f, 18.0f, 68.0f, 20.0f, 64.0f, 24.0f, 68.0f, 26.0f, 64.0f, 30.0f, 68.0f, 32.0f, 64.0f, 36.0f, 68.0f})), new LinkedHashMap<>(), 1.875f, -0.8125f, -7.015f, 0.0f, 0.0f, 0.0f);
        ModelPart p4 = part(List.of(cube(new float[]{-0.46875f, -0.8125f, -1.0f, 0.46875f, 0.8125f, 1.0f}, new float[]{91.0f, 11.0f, 92.0f, 13.0f, 94.0f, 11.0f, 96.0f, 13.0f, 98.0f, 11.0f, 99.0f, 13.0f, 101.0f, 11.0f, 103.0f, 13.0f, 105.0f, 11.0f, 106.0f, 13.0f, 108.0f, 11.0f, 109.0f, 13.0f})), new LinkedHashMap<>(), 2.34375f, 1.625f, -8.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p5 = part(List.of(cube(new float[]{-0.46875f, -0.8125f, -0.5f, 0.46875f, 0.8125f, 0.5f}, new float[]{111.0f, 11.0f, 112.0f, 13.0f, 114.0f, 11.0f, 115.0f, 13.0f, 117.0f, 11.0f, 118.0f, 13.0f, 120.0f, 11.0f, 121.0f, 13.0f, 123.0f, 11.0f, 124.0f, 12.0f, 126.0f, 11.0f, 127.0f, 12.0f})), new LinkedHashMap<>(), 0.0f, -0.8125f, 0.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p6 = part(List.of(cube(new float[]{-0.46875f, -0.40625f, -1.0f, 0.46875f, 0.40625f, 1.0f}, new float[]{1.0f, 21.0f, 2.0f, 22.0f, 4.0f, 21.0f, 6.0f, 22.0f, 8.0f, 21.0f, 9.0f, 22.0f, 11.0f, 21.0f, 13.0f, 22.0f, 15.0f, 21.0f, 16.0f, 23.0f, 18.0f, 21.0f, 19.0f, 23.0f})), new LinkedHashMap<>(), 0.0f, -1.21875f, -1.5f, 0.0f, 0.0f, 0.0f);

        Map<String, ModelPart> p7Children = new LinkedHashMap<>();
        p7Children.put("mesh_6", p5);
        p7Children.put("mesh_7", p6);

        ModelPart p7 = part(List.of(), p7Children, 2.34375f, -2.4375f, -4.5f, 0.0f, 0.0f, 0.0f);
        ModelPart p8 = part(List.of(cube(new float[]{-0.9375f, -0.8125f, -0.025f, 0.9375f, 0.8125f, 0.025f}, new float[]{2.0f, 70.0f, 6.0f, 74.0f, 8.0f, 70.0f, 12.0f, 74.0f, 14.0f, 70.0f, 18.0f, 74.0f, 20.0f, 70.0f, 24.0f, 74.0f, 26.0f, 70.0f, 30.0f, 74.0f, 32.0f, 70.0f, 36.0f, 74.0f})), new LinkedHashMap<>(), -1.875f, -0.8125f, -7.015f, 0.0f, 0.0f, 0.0f);
        ModelPart p9 = part(List.of(cube(new float[]{-0.46875f, -0.8125f, -1.0f, 0.46875f, 0.8125f, 1.0f}, new float[]{43.0f, 21.0f, 44.0f, 23.0f, 46.0f, 21.0f, 48.0f, 23.0f, 50.0f, 21.0f, 51.0f, 23.0f, 53.0f, 21.0f, 55.0f, 23.0f, 57.0f, 21.0f, 58.0f, 23.0f, 60.0f, 21.0f, 61.0f, 23.0f})), new LinkedHashMap<>(), -2.34375f, 1.625f, -8.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p10 = part(List.of(cube(new float[]{-0.46875f, -0.8125f, -0.5f, 0.46875f, 0.8125f, 0.5f}, new float[]{63.0f, 21.0f, 64.0f, 23.0f, 66.0f, 21.0f, 67.0f, 23.0f, 69.0f, 21.0f, 70.0f, 23.0f, 72.0f, 21.0f, 73.0f, 23.0f, 75.0f, 21.0f, 76.0f, 22.0f, 78.0f, 21.0f, 79.0f, 22.0f})), new LinkedHashMap<>(), 0.0f, -0.8125f, 0.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p11 = part(List.of(cube(new float[]{-0.46875f, -0.40625f, -1.0f, 0.46875f, 0.40625f, 1.0f}, new float[]{81.0f, 21.0f, 82.0f, 22.0f, 84.0f, 21.0f, 86.0f, 22.0f, 88.0f, 21.0f, 89.0f, 22.0f, 91.0f, 21.0f, 93.0f, 22.0f, 95.0f, 21.0f, 96.0f, 23.0f, 98.0f, 21.0f, 99.0f, 23.0f})), new LinkedHashMap<>(), 0.0f, -1.21875f, -1.5f, 0.0f, 0.0f, 0.0f);

        Map<String, ModelPart> p12Children = new LinkedHashMap<>();
        p12Children.put("mesh_11", p10);
        p12Children.put("mesh_12", p11);

        ModelPart p12 = part(List.of(), p12Children, -2.34375f, -2.4375f, -4.5f, 0.0f, 0.0f, 0.0f);

        Map<String, ModelPart> p13Children = new LinkedHashMap<>();
        p13Children.put("mesh_3", p2);
        p13Children.put("mesh_4", p3);
        p13Children.put("mesh_5", p4);
        p13Children.put("antena_izquierda", p7);
        p13Children.put("mesh_9", p8);
        p13Children.put("mesh_10", p9);
        p13Children.put("antena_derecha", p12);
        ModelPart p13 = part(List.of(), p13Children, 0.0f, -3.9375f, -0.5f, 0.0f, 0.0f, 0.0f);
        ModelPart p14 = part(List.of(cube(new float[]{-2.63740798f, -0.5f, -0.5f, 2.63740798f, 0.5f, 0.5f}, new float[]{101.0f, 21.0f, 107.0f, 22.0f, 109.0f, 21.0f, 110.0f, 22.0f, 112.0f, 21.0f, 118.0f, 22.0f, 120.0f, 21.0f, 121.0f, 22.0f, 1.0f, 25.0f, 7.0f, 26.0f, 9.0f, 25.0f, 15.0f, 26.0f})), new LinkedHashMap<>(), 1.5f, 0.298390417f, -2.14869356f, 2.98092403f, -0.95220988f, -2.94522909f);
        ModelPart p15 = part(List.of(cube(new float[]{-3.00998339f, -0.5f, -0.5f, 3.00998339f, 0.5f, 0.5f}, new float[]{17.0f, 25.0f, 24.0f, 26.0f, 26.0f, 25.0f, 27.0f, 26.0f, 29.0f, 25.0f, 36.0f, 26.0f, 38.0f, 25.0f, 39.0f, 26.0f, 41.0f, 25.0f, 48.0f, 26.0f, 50.0f, 25.0f, 57.0f, 26.0f})), new LinkedHashMap<>(), -1.6f, 0.5f, -2.5f, 0.253949249f, -0.980129266f, -0.302884868f);
        Map<String, ModelPart> p16Children = new LinkedHashMap<>();
        p16Children.put("mesh_16", p15);
        ModelPart p16 = part(List.of(), p16Children, 3.0f, 0.596780834f, -4.29738711f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p17Children = new LinkedHashMap<>();
        p17Children.put("mesh_15", p14);
        p17Children.put("codo_izquierda_1", p16);
        ModelPart p17 = part(List.of(), p17Children, 2.5f, -1.59678083f, -0.202612886f, 0.0f, 0.0f, 0.0f);
        ModelPart p18 = part(List.of(cube(new float[]{-2.63740798f, -0.5f, -0.5f, 2.63740798f, 0.5f, 0.5f}, new float[]{46.0f, 33.0f, 52.0f, 34.0f, 54.0f, 33.0f, 55.0f, 34.0f, 57.0f, 33.0f, 63.0f, 34.0f, 65.0f, 33.0f, 66.0f, 34.0f, 68.0f, 33.0f, 74.0f, 34.0f, 76.0f, 33.0f, 82.0f, 34.0f})), new LinkedHashMap<>(), -1.5f, 0.298390417f, -2.14869356f, 0.160668628f, -0.95220988f, -0.196363563f);
        ModelPart p19 = part(List.of(cube(new float[]{-3.00998339f, -0.5f, -0.5f, 3.00998339f, 0.5f, 0.5f}, new float[]{84.0f, 33.0f, 91.0f, 34.0f, 93.0f, 33.0f, 94.0f, 34.0f, 96.0f, 33.0f, 103.0f, 34.0f, 105.0f, 33.0f, 106.0f, 34.0f, 108.0f, 33.0f, 115.0f, 34.0f, 117.0f, 33.0f, 124.0f, 34.0f})), new LinkedHashMap<>(), 1.6f, 0.5f, -2.5f, 2.8876434f, -0.980129266f, -2.83870779f);
        Map<String, ModelPart> p20Children = new LinkedHashMap<>();
        p20Children.put("mesh_20", p19);
        ModelPart p20 = part(List.of(), p20Children, -3.0f, 0.596780834f, -4.29738711f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p21Children = new LinkedHashMap<>();
        p21Children.put("mesh_19", p18);
        p21Children.put("codo_derecha_1", p20);
        ModelPart p21 = part(List.of(), p21Children, -2.5f, -1.59678083f, -0.202612886f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p22Children = new LinkedHashMap<>();
        ModelPart p22 = part(List.of(), p22Children, 0.0f, -0.3f, -10.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p23Children = new LinkedHashMap<>();
        p23Children.put("mesh_1", p0);
        p23Children.put("mesh_2", p1);
        p23Children.put("cabeza", p13);
        p23Children.put("pata_izquierda_1", p17);
        p23Children.put("pata_derecha_1", p21);
        p23Children.put("agarre_item", p22);
        ModelPart p23 = part(List.of(), p23Children, 0.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p24 = part(List.of(cube(new float[]{-4.0f, -3.0f, -4.0f, 4.0f, 3.0f, 4.0f}, new float[]{71.0f, 1.0f, 79.0f, 7.0f, 81.0f, 1.0f, 89.0f, 7.0f, 91.0f, 1.0f, 99.0f, 7.0f, 101.0f, 1.0f, 109.0f, 7.0f, 111.0f, 1.0f, 119.0f, 9.0f, 1.0f, 11.0f, 9.0f, 19.0f})), new LinkedHashMap<>(), 0.0f, -1.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p25Children = new LinkedHashMap<>();
        p25Children.put("mesh_25", p24);
        ModelPart p25 = part(List.of(), p25Children, 0.0f, -8.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p26 = part(List.of(cube(new float[]{-2.5f, -0.5f, -0.5f, 2.5f, 0.5f, 0.5f}, new float[]{59.0f, 25.0f, 64.0f, 26.0f, 66.0f, 25.0f, 67.0f, 26.0f, 69.0f, 25.0f, 74.0f, 26.0f, 76.0f, 25.0f, 77.0f, 26.0f, 79.0f, 25.0f, 84.0f, 26.0f, 86.0f, 25.0f, 91.0f, 26.0f})), new LinkedHashMap<>(), 2.5f, 0.0f, 0.0f, -3.14159265f, -1.2246468e-16f, 3.14159265f);
        ModelPart p27 = part(List.of(cube(new float[]{-0.5f, -2.75f, -0.5f, 0.5f, 2.75f, 0.5f}, new float[]{93.0f, 25.0f, 94.0f, 31.0f, 96.0f, 25.0f, 97.0f, 31.0f, 99.0f, 25.0f, 100.0f, 31.0f, 102.0f, 25.0f, 103.0f, 31.0f, 105.0f, 25.0f, 106.0f, 26.0f, 108.0f, 25.0f, 109.0f, 26.0f})), new LinkedHashMap<>(), 0.0f, 2.75f, 3.33066907e-16f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p28Children = new LinkedHashMap<>();
        p28Children.put("mesh_28", p27);
        ModelPart p28 = part(List.of(), p28Children, 5.0f, 0.0f, -3.33066907e-16f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p29Children = new LinkedHashMap<>();
        p29Children.put("mesh_27", p26);
        p29Children.put("codo_izquierda_2", p28);
        ModelPart p29 = part(List.of(), p29Children, 2.5f, -5.5f, 1.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p30 = part(List.of(cube(new float[]{-2.91547595f, -0.5f, -0.5f, 2.91547595f, 0.5f, 0.5f}, new float[]{111.0f, 25.0f, 117.0f, 26.0f, 119.0f, 25.0f, 120.0f, 26.0f, 1.0f, 33.0f, 7.0f, 34.0f, 9.0f, 33.0f, 10.0f, 34.0f, 12.0f, 33.0f, 18.0f, 34.0f, 20.0f, 33.0f, 26.0f, 34.0f})), new LinkedHashMap<>(), 2.5f, 0.0f, 1.5f, -3.14159265f, 0.5404195f, 3.14159265f);
        ModelPart p31 = part(List.of(cube(new float[]{-0.5f, -2.75f, -0.5f, 0.5f, 2.75f, 0.5f}, new float[]{28.0f, 33.0f, 29.0f, 39.0f, 31.0f, 33.0f, 32.0f, 39.0f, 34.0f, 33.0f, 35.0f, 39.0f, 37.0f, 33.0f, 38.0f, 39.0f, 40.0f, 33.0f, 41.0f, 34.0f, 43.0f, 33.0f, 44.0f, 34.0f})), new LinkedHashMap<>(), 0.0f, 2.75f, 0.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p32Children = new LinkedHashMap<>();
        p32Children.put("mesh_32", p31);
        ModelPart p32 = part(List.of(), p32Children, 5.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p33Children = new LinkedHashMap<>();
        p33Children.put("mesh_31", p30);
        p33Children.put("codo_izquierda_3", p32);
        ModelPart p33 = part(List.of(), p33Children, 2.5f, -5.5f, 3.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p34 = part(List.of(cube(new float[]{-2.5f, -0.5f, -0.5f, 2.5f, 0.5f, 0.5f}, new float[]{1.0f, 41.0f, 6.0f, 42.0f, 8.0f, 41.0f, 9.0f, 42.0f, 11.0f, 41.0f, 16.0f, 42.0f, 18.0f, 41.0f, 19.0f, 42.0f, 21.0f, 41.0f, 26.0f, 42.0f, 28.0f, 41.0f, 33.0f, 42.0f})), new LinkedHashMap<>(), -2.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p35 = part(List.of(cube(new float[]{-0.5f, -2.75f, -0.5f, 0.5f, 2.75f, 0.5f}, new float[]{35.0f, 41.0f, 36.0f, 47.0f, 38.0f, 41.0f, 39.0f, 47.0f, 41.0f, 41.0f, 42.0f, 47.0f, 44.0f, 41.0f, 45.0f, 47.0f, 47.0f, 41.0f, 48.0f, 42.0f, 50.0f, 41.0f, 51.0f, 42.0f})), new LinkedHashMap<>(), 0.0f, 2.75f, 0.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p36Children = new LinkedHashMap<>();
        p36Children.put("mesh_36", p35);
        ModelPart p36 = part(List.of(), p36Children, -5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p37Children = new LinkedHashMap<>();
        p37Children.put("mesh_35", p34);
        p37Children.put("codo_derecha_2", p36);
        ModelPart p37 = part(List.of(), p37Children, -2.5f, -5.5f, 1.0f, 0.0f, 0.0f, 0.0f);
        ModelPart p38 = part(List.of(cube(new float[]{-2.91547595f, -0.5f, -0.5f, 2.91547595f, 0.5f, 0.5f}, new float[]{53.0f, 41.0f, 59.0f, 42.0f, 61.0f, 41.0f, 62.0f, 42.0f, 64.0f, 41.0f, 70.0f, 42.0f, 72.0f, 41.0f, 73.0f, 42.0f, 75.0f, 41.0f, 81.0f, 42.0f, 83.0f, 41.0f, 89.0f, 42.0f})), new LinkedHashMap<>(), -2.5f, 0.0f, 1.5f, 0.0f, 0.5404195f, 0.0f);
        ModelPart p39 = part(List.of(cube(new float[]{-0.5f, -2.75f, -0.5f, 0.5f, 2.75f, 0.5f}, new float[]{91.0f, 41.0f, 92.0f, 47.0f, 94.0f, 41.0f, 95.0f, 47.0f, 97.0f, 41.0f, 98.0f, 47.0f, 100.0f, 41.0f, 101.0f, 47.0f, 103.0f, 41.0f, 104.0f, 42.0f, 106.0f, 41.0f, 107.0f, 42.0f})), new LinkedHashMap<>(), 0.0f, 2.75f, 0.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p40Children = new LinkedHashMap<>();
        p40Children.put("mesh_40", p39);
        ModelPart p40 = part(List.of(), p40Children, -5.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p41Children = new LinkedHashMap<>();
        p41Children.put("mesh_39", p38);
        p41Children.put("codo_derecha_3", p40);
        ModelPart p41 = part(List.of(), p41Children, -2.5f, -5.5f, 3.0f, 0.0f, 0.0f, 0.0f);
        Map<String, ModelPart> p42Children = new LinkedHashMap<>();
        p42Children.put("torax", p23);
        p42Children.put("abdomen", p25);
        p42Children.put("pata_izquierda_2", p29);
        p42Children.put("pata_izquierda_3", p33);
        p42Children.put("pata_derecha_2", p37);
        p42Children.put("pata_derecha_3", p41);
        ModelPart p42 = part(List.of(), p42Children, 0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        return part(List.of(), Map.of("red_ant", p42), 0, 0, 0, 0, 0, 0);
    }
    private static ModelPart part(List<ModelPart.Cube> cubes, Map<String, ModelPart> children,
            float x, float y, float z, float rx, float ry, float rz) {
        ModelPart p = new ModelPart(cubes, children);
        PartPose pose = PartPose.offsetAndRotation(x,y,z,rx,ry,rz);
        p.setInitialPose(pose); p.loadPose(pose); return p;
    }
    private static ModelPart.Cube cube(float[] b, float[] uv) {
        float x=b[0],y=b[1],z=b[2],X=b[3],Y=b[4],Z=b[5];
        ModelPart.Cube cube = new ModelPart.Cube(0,0,-X,-Y,z,X-x,Y-y,Z-z,0,0,0,false,128,128,EnumSet.allOf(Direction.class));
        float[][][] vertices={
            {{x,y,z},{X,y,z},{X,Y,z},{x,Y,z}},
            {{X,y,z},{X,y,Z},{X,Y,Z},{X,Y,z}},
            {{X,y,Z},{x,y,Z},{x,Y,Z},{X,Y,Z}},
            {{x,y,Z},{x,y,z},{x,Y,z},{x,Y,Z}},
            {{x,Y,z},{X,Y,z},{X,Y,Z},{x,Y,Z}},
            {{x,y,Z},{X,y,Z},{X,y,z},{x,y,z}}
        };
        float[][] normals={{0,0,-1},{1,0,0},{0,0,1},{-1,0,0},{0,1,0},{0,-1,0}};
        for(int face=0;face<6;face++) {
            int o=face*4;
            float[][] tex={{uv[o],uv[o+3]},{uv[o+2],uv[o+3]},{uv[o+2],uv[o+1]},{uv[o],uv[o+1]}};
            ModelPart.Vertex[] quad=new ModelPart.Vertex[4];
            for(int j=0;j<4;j++) {
                int k=3-j; float[] v=vertices[face][k];
                quad[j]=new ModelPart.Vertex(-v[0],-v[1],v[2],tex[k][0]/128,tex[k][1]/128);
            }
            float[] n=normals[face];
            cube.polygons[face]=new ModelPart.Polygon(quad,new Vector3f(-n[0],-n[1],n[2]));
        }
        return cube;
    }
}
