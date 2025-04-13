package rpg.Jogo;

import javax.sound.sampled.*;

public class SomInterface {
    private static SourceDataLine sdl;

    static {
        try {
            AudioFormat af = new AudioFormat(8000f, 8, 1, true, false);
            sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playBeep() {
        if (sdl == null) return;

        float frequency = 1400f; // som mais agudo e mais "click"
        int duration = 25; // duração mais curta
        byte[] buf = new byte[1];

        for (int i = 0; i < duration * 8; i++) {
            double angle = i / (8000f / frequency) * 2.0 * Math.PI;
            buf[0] = (byte)(Math.sin(angle) * 60); // menor volume para ficar suave
            sdl.write(buf, 0, 1);
        }
    }

    public static void fecharBeep() {
        if (sdl != null) {
            sdl.drain();
            sdl.stop();
            sdl.close();
        }
    }
}
