import java.io.*;
import java.util.Vector;

public class Demo {

    private int readerPos = 0;

    private int demoProtocol;

    private int netProtocol;

    private String hostName;

    private String clientName;

    private String mapName;

    private String gameDir;

    private float time;

    private int ticks;

    private int frames;

    private int tickrate;

    private int signOnLength;

//    private byte[] buffer;

    private BufferedInputStream bufferStream;

    public Demo(String demoName) throws IOException {
        File demoFile = new File(demoName);
        bufferStream = new BufferedInputStream(new FileInputStream(demoFile));
        System.out.println(readString(8));
        System.out.println(demoProtocol = readInt());
        System.out.println(netProtocol = readInt());
        System.out.println(hostName = readString(260));
        System.out.println(clientName = readString(260));
        System.out.println(mapName = readString(260));
        System.out.println(gameDir = readString(260));
        System.out.println(time = readFloat());
        System.out.println(ticks = readInt());
        System.out.println(frames = readInt());
        System.out.println(tickrate = (int) (ticks/time));
        System.out.println(signOnLength = readInt());
        System.out.println(bufferStream.read());
    }

//    private void parsePacket() throws IOException {
//        bufferStream.skip(160);
//        int chunkSize = readInt();
//
//    }

    private String readString(int length) throws IOException {
        String string = "";
        for (int i = 0; i < length; i++) {
            string += (char) bufferStream.read();
        }
        return string;
    }

    private int readInt() throws IOException {
        return (bufferStream.read() & 0xFF) | (bufferStream.read() & 0xFF) << 8 | (bufferStream.read() & 0xFF) << 16 | (bufferStream.read() & 0xFF) << 24;
    }

    private float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }
}
