package com.trilogyed;

public class ModulusAnimation {
    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 300; i++) {
            if (i % 30 == 0)
                System.out.print("                            (\r");
            else if (i % 30 == 1)
                System.out.print("                           (^\r");
            else if (i % 30 == 2)
                System.out.print("                         <('.\r");
            else if (i % 30 == 3)
                System.out.print("                        (v'.'\r");
            else if (i % 30 == 4)
                System.out.print("                      (>'.')>\r");
            else if (i % 30 == 5)
                System.out.print("                    (^'.'^)  \r");
            else if (i % 30 == 6)
                System.out.print("                   <('.'<)   \r");
            else if (i % 30 == 7)
                System.out.print("                  (v'.'v)    \r");
            else if (i % 30 == 8)
                System.out.print("                 (>'.')>     \r");
            else if (i % 30 == 9)
                System.out.print("               (^'.'^)       \r");
            else if (i % 30 == 10)
                System.out.print("              <('.'<)        \r");
            else if (i % 30 == 11)
                System.out.print("             (v'.'v)         \r");
            else if (i % 30 == 12)
                System.out.print("            (>'.')>          \r");
            else if (i % 30 == 13)
                System.out.print("          (^'.'^)            \r");
            else if (i % 30 == 14)
                System.out.print("         <('.'<)             \r");
            else if (i % 30 == 15)
                System.out.print("        (v'.'v)              \r");
            else if (i % 30 == 16)
                System.out.print("       (>'.')>               \r");
            else if (i % 30 == 17)
                System.out.print("      (^'.'^)                \r");
            else if (i % 30 == 18)
                System.out.print("     <('.'<)                 \r");
            else if (i % 30 == 19)
                System.out.print("    (v'.'v)                  \r");
            else if (i % 30 == 20)
                System.out.print("   (>'.')>                   \r");
            else if (i % 30 == 21)
                System.out.print(" (^'.'^)                     \r");
            else if (i % 30 == 22)
                System.out.print("('.'<)                       \r");
            else if (i % 30 == 23)
                System.out.print("'.'v)                        \r");
            else if (i % 30 == 24)
                System.out.print(".')>                         \r");
            else if (i % 30 == 25)
                System.out.print("^)                           \r");
            else if (i % 30 == 26)
                System.out.print(")                            \r");
            else if (i % 30 == 27)
                System.out.print("                             \r");
            else if (i % 30 == 28)
                System.out.print("                             \r");
            else if (i % 30 == 29)
                System.out.print("                             \r");

            Thread.sleep(250);
        }

    }
}
