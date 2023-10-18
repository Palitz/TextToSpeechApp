import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.util.Scanner;

public class TextToSpeechApp {

    public static void main(String[] args) {
        // Set the FreeTTS voice directory
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        // Set the voice
        String voiceName = "kevin16";
        Voice voice = getVoice(voiceName);

        // Get user input for text
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text to be spoken: ");
        String text = scanner.nextLine();

        // Perform text-to-speech
        textToSpeech(voice, text);

        // Close the scanner
        scanner.close();
    }

    private static Voice getVoice(String voiceName) {
        VoiceManager voiceManager = VoiceManager.getInstance();
        return voiceManager.getVoice(voiceName);
    }

    private static void textToSpeech(Voice voice, String text) {
        if (voice != null) {
            voice.allocate();
            voice.speak(text);
            voice.deallocate();
        } else {
            System.err.println("Error: Could not find voice. Check if the voice name is correct.");
        }
    }
}
