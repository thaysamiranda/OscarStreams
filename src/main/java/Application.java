import mapper.OscarMapper;
import model.OscarModel;
import service.OscarService;
import java.io.IOException;
import java.util.List;
import util.FileUtil;

public class Application {

    public static void main(String[] args) throws IOException {

        OscarService oscarService = getOscarService();
        oscarService.atorMaisJovem();
        oscarService.atorMaisPremiado();
        oscarService.atorJovemMaisPremiado();

    }
    private static OscarService getOscarService() throws IOException {
        var fileOscarFemale = new FileUtil<OscarModel>("oscar_age_female.csv".lines());
        var fileOscarMale = new FileUtil<OscarModel>("oscar_age_male.csv".lines());
        List<OscarModel> OscarMale = fileOscarMale.readStream(new OscarMapper());
        List<OscarModel> OscarFemale = fileOscarFemale.readStream(new OscarMapper());
        return new OscarService(OscarMale, OscarFemale);
    }
}
