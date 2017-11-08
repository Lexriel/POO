package image;

public class Main {
    // ======================================================================
    public static void main(String[] args) {
        System.out.println("usage : java image.Main fileName threshold nbGrayLevels (default : /images/lamp.pgm 20 8)");
        
        String imageFileName;
        if (args.length < 1) {
            imageFileName = "/images/lamp.pgm";
        } else {
            imageFileName =  args[0];
        }
        int limite = 20; // default
        if (args.length >= 2) {
            limite = Integer.parseInt(args[1]);
        } 
        int nbGrayLevels = 8; // default
        if (args.length >= 3) {
            nbGrayLevels = Integer.parseInt(args[2]);
        } 

        
        ImageDisplayer displayer = new ImageDisplayer();
        
        Image imgPGM = Image.initImagePGM(imageFileName);
        displayer.display(imgPGM,"PGM",100,100);
        Image contour = imgPGM.edge(limite);
        displayer.display(contour, "edge : PGM", 110+imgPGM.getWidth(), 100);
        displayer.display(imgPGM.decreaseGrayLevels(nbGrayLevels), nbGrayLevels+" gray levels : PGM", 130+2*imgPGM.getWidth(), 100);

        
//        Image img = new Image(100, 200);
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 200; j++) {
//                img.setPixel(i, j, new Pixel(GrayColor.NOIR));
//            }
//        }
//        for (int i = 10; i < 30; i++) {
//            for (int j = 30; j < 60; j++) {
//                img.setPixel(i, j, new Pixel(GrayColor.NOIR));
//            }
//        }
//        for (int i = 50; i < 70; i++) {
//            for (int j = 50; j < 100; j++) {
//                img.setPixel(i, j, new Pixel(new GrayColor(64)));
//            }
//        }
//        for (int i = 20; i < 50; i++) {
//            for (int j = 110; j < 140; j++) {
//                img.setPixel(i, j, new Pixel(new GrayColor(240)));
//            }
//        }
//        displayer.display(img,"two squares", 100, 120+imgPGM.getHeight());
//        Image imgEdge = img.edge(50);
//        displayer.display(imgEdge,"edge : two squares", 120+img.getWidth(),120+imgPGM.getHeight());
    }

}
