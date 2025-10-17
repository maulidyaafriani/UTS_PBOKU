import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Plant p = new Plant();

        System.out.println("=== GAME ZOMBIE vs PLANT ===");

        // Input data WalkingZombie
        System.out.print("Masukkan health WalkingZombie: ");
        int wzHealth = sc.nextInt();
        System.out.print("Masukkan level WalkingZombie (1-3): ");
        int wzLevel = sc.nextInt();
        WalkingZombie wz = new WalkingZombie(wzHealth, wzLevel);

        // Input data JumpingZombie
        System.out.print("Masukkan health JumpingZombie: ");
        int jzHealth = sc.nextInt();
        System.out.print("Masukkan level JumpingZombie (1-3): ");
        int jzLevel = sc.nextInt();
        JumpingZombie jz = new JumpingZombie(jzHealth, jzLevel);

        // Input data Barrier
        System.out.print("Masukkan kekuatan Barrier: ");
        int bStrength = sc.nextInt();
        Barrier b = new Barrier(bStrength);

        System.out.println("\n=== STATUS AWAL ===");
        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());

        System.out.print("\nMasukkan berapa kali plant menyerang: ");
        int serangan = sc.nextInt();

        int countWZ = 0, countJZ = 0, countB = 0;
        boolean wzKalah = false, jzKalah = false, bKalah = false;

        System.out.println("\n=== Plant Menyerang! ===");

        for (int i = 1; i <= serangan; i++) {
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);

            if (!wzKalah && wz.getHealth() == 0) {
                wzKalah = true;
                countWZ = i;
                System.out.println("⚠️ Walking Zombie kalah setelah " + countWZ + " serangan!");
            }
            if (!jzKalah && jz.getHealth() == 0) {
                jzKalah = true;
                countJZ = i;
                System.out.println("⚠️ Jumping Zombie kalah setelah " + countJZ + " serangan!");
            }
            if (!bKalah && b.getStrength() == 0) {
                bKalah = true;
                countB = i;
                System.out.println("⚠️ Barrier kalah setelah " + countB + " serangan!");
            }
        }

        System.out.println("\n=== STATUS SETELAH DISERANG ===");
        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());

        sc.close();
    }
}
