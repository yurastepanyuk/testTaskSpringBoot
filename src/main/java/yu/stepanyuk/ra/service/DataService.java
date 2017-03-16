package yu.stepanyuk.ra.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import yu.stepanyuk.ra.entity.Data;
import yu.stepanyuk.ra.repository.DataRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    private DataRepository dataRepository;

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<Data> findAll(){
        return dataRepository.findAll();
    }

    public Data findById(Long id){
        return dataRepository.findOne(id);
    }

    public void addNewData(Data data) {
        dataRepository.save(data);
    }

    public void updateData(Data data, Long id) {
        Data dataDB = dataRepository.findOne(id);
        dataDB.setCss_grade(data.getCss_grade());
        dataDB.setEngine_version(data.getEngine_version());
        dataDB.setBrowser(data.getBrowser());
        dataDB.setPlatform(data.getPlatform());
        dataDB.setRendering_engine(data.getRendering_engine());
        dataRepository.save(dataDB);
    }

    public void deleteData(Long id) {
        dataRepository.delete(Long.valueOf(id));

        //Data is deleted with StreamApi. For example.
//        Data dataForDel = dataRepository.findAll().stream().filter(curData -> curData.getId().equals(id)).findFirst().get();
//        dataRepository.delete(dataForDel);
    }

    public List<Data> getSummaryData() {

        List<Data> result = new ArrayList<>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT * FROM full_features data GROUP BY data.rendering_engine;");
        while (rowSet.next()) {
            result.add(new Data(Long.valueOf(rowSet.getBigDecimal("id_data").toString()),
                    rowSet.getString("rendering_engine"),
                    rowSet.getString("browser"),
                    rowSet.getString("platform"),
                    rowSet.getString("engine_version"),
                    rowSet.getString("css_grade")));
        }

        return result;
    }
}
