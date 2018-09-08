import factories.StoreFactory;
import file.FileTools;
import org.apache.commons.io.FileUtils;
import process.Analytics;
import vo.BasicData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rneis on 07/09/2018.
 */
public class ProjectInitializer {

    public static void main(String[] args) throws IOException {
        List<BasicData> basicDataList = new ArrayList<BasicData>();
        List<String> fileNames = new ArrayList<String>();

        while (true) {
            boolean hasAnyNewFile = false;
            List<File> files = FileTools.readAllDatFiles();

            for (File file : files) {
                if (!fileNames.contains(file.getName())) {
                    List<String> lines = FileUtils.readLines(file, "ISO-8859-1");

                    for (String line : lines) {
                        BasicData basicData = new StoreFactory(line).getObject();
                        basicDataList.add(basicData);
                    }

                    fileNames.add(file.getName());
                    hasAnyNewFile = true;
                }
            }

            if (hasAnyNewFile) {
                Analytics projectAnalytics = new Analytics(basicDataList);
                StringBuilder outPutData = new StringBuilder("The results of the analytics are:");
                outPutData.append('\n').append("Number of Clients = [" + projectAnalytics.getNumberOfClients() + "]");
                outPutData.append('\n').append("Number of Sales Man = [" + projectAnalytics.getNumberOfSalesMan() + "]");
                outPutData.append('\n').append("ID of the most Expensive sale = [" + projectAnalytics.getTheSaleIdOfTheMostExpensiveSale() + "]");
                outPutData.append('\n').append("The worst SalesMan is = [" + projectAnalytics.getWorstSalesMan() + "]");

                FileTools.saveOutPutfile(outPutData.toString());
            }
        }
    }
}
