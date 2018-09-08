package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by rneis on 07/09/2018.
 */
public class FileTools {
    private static String homePath = System.getenv("HOMEPATH");
    private static final String DEFAULT_FILE_DIRECTORY = homePath + File.separator + "data" + File.separator;
    private static final String FILE_PATH_IN = DEFAULT_FILE_DIRECTORY + "in" + File.separator;
    private static final String FILE_PATH_OUT = DEFAULT_FILE_DIRECTORY + "OUT" + File.separator;

    public static List<File> readAllDatFiles() {
        File dir = new File(FILE_PATH_IN);
        String[] extensions = new String[]{"dat"};
        List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
        return files;
    }

    public static void saveOutPutfile(String outPutData) {
        File file = new File(FILE_PATH_OUT + "RodrigoNeis.done.dat");
        try {
            FileUtils.writeStringToFile(file, outPutData, "ISO-8859-1", false);
            System.out.println("The file was created or updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
