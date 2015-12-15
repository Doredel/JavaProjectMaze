package model;
import java.lang.instrument.Instrumentation;
public class ObjectSizeFetcher {
	
	    public static Instrumentation instrumentation;

	    public static void premain(String args, Instrumentation inst) {
	        instrumentation = inst;
	    }

	    public static long getObjectSize(int[][][] arr) {
	        return instrumentation.getObjectSize(arr);
	    }
	}
