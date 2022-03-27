
class enumExample {
    enum Levels {
        LOW,
        MEDIUM,
        HIGH
    }

    public static void main(String[] args) {
        System.out.println("The Available Levels...");

        for (Levels l : Levels.values()) {
            System.out.println(l);
        }

        System.out.println("\nThe Current Level is: ");
        Levels lv1 = Levels.MEDIUM;
        switch(lv1) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }
    }
}

// the output will be...
// The Available Levels...
// LOW
// MEDIUM
// HIGH
//
// The Current Level is: 
// Medium level