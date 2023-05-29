package com.kenzie.partsmanager;

import java.util.Arrays;
/**
 * A class that simulates a list of microphone parts
 */
public class SamplePartList {
    /**
     * Creates a SamplePartList for the learners to see what is returned
     * when working with hashCode and equals.
     *
     * @param args ignored
     */
    public static void main(String[] args){

        DevicePart flex = new DevicePart("Knowles", "KAS-700-0147",
                Arrays.asList(AmazonDevice.FIRE_TV_STICK, AmazonDevice.FIRE_TV_STICK_4K, AmazonDevice.ECHO_BUDS));
        System.out.println(flex.hashCode());

        DevicePart button = new DevicePart("CUI Devices", "CMEJ-04150420P",
                Arrays.asList(AmazonDevice.ECHO_PLUS));
        System.out.println(button.hashCode());

        DevicePart omnidirectional = new DevicePart("Knowles", "FG-23329-P142",
                Arrays.asList(AmazonDevice.ECHO_PLUS));
        System.out.println(omnidirectional.hashCode());

        DevicePart noiseCancelling = new DevicePart("Knowles", "FB-EM-30342-000",
                Arrays.asList(AmazonDevice.ECHO_BUDS));
        System.out.println(noiseCancelling.hashCode());

        DevicePart cuiDevice = new DevicePart("CUI Devices", "CMEJ-04150420P",
                Arrays.asList(AmazonDevice.ECHO_PLUS));
        System.out.println(cuiDevice.hashCode());

        DevicePart wired = new DevicePart("Knowles", "VFG-30747-000",
                Arrays.asList(AmazonDevice.FIRE_7_KIDS_EDITION, AmazonDevice.FIRE_HD_8_KIDS_EDITION, AmazonDevice.FIRE_HD_10_KIDS_EDITION));
        System.out.println(wired.hashCode());

        DevicePart cord = new DevicePart("CUI Devices", "CMEJ-4622-25-L082",
                Arrays.asList(AmazonDevice.ECHO));
        System.out.println(cord.hashCode());

        DevicePart grounded = new DevicePart("Knowles", "EK-26899-P03",
                Arrays.asList(AmazonDevice.ECHO_FRAMES));
        System.out.println(grounded.hashCode());

        DevicePart puiAudio = new DevicePart("PUI Audio", "AMM-2738B-R",
                Arrays.asList(AmazonDevice.ECHO_DOT, AmazonDevice.ECHO_SHOW_5, AmazonDevice.ECHO_SHOW_8));
        System.out.println(puiAudio.hashCode());
    }
}
