package utils;

public class Constants {
    public static class PlayerConstants{
        public static final int RUNNING = 0;
        public static final int IDLE = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;

        public static int GetSpriteAmount(int player_action){
            switch (player_action) {
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case JUMP:
                case FALLING:
                case GROUND:
                    return 2;
                case HIT:
                    return 4;
                case ATTACK_1:
                case ATTACK_JUMP_1:
                case ATTACK_JUMP_2:
                    return 3;
                default:
                    return 1;
            }
        }
    }
}