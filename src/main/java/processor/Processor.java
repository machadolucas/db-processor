package processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import processor.db.DataObjectRepository;
import processor.repository.GRRepository;
import processor.repository.*;
import processor.entity.DataObject;
import processor.entity.GR;
import processor.entity.*;

@Component
public class Processor {
    //@Autowired
    //private DataObjectRepository repository;


    @Autowired
    private GRRepository gRRepository = new GRRepository();

    @Autowired
    private AIDRepository aIDRepository = new AIDRepository();

    @Autowired
    AbstractRepository abstractReposity = new AbstractRepository();

    @Autowired
    private FAURepository fAURepository = new FAURepository()

    @Autowired
    private LARepository lARepository = new LARepository()

    @Autowired
    private MHRepository mHRepository = new MHRepository();

    @Autowired
    private PLRepository pLRepository = new PLRepository();

    @Autowired
    private ISRepository iSRepository = new ISRepository();
    @Autowired
    private PTRepository pTRepository = new PTRepository();

    @Autowired
    private PHSTRepository pHSTRepository = new PHSTRepository();


    @PostConstruct
    public void init() {
        System.out.println("==========================================================");
        System.out.println("Processador de texto para uma estrutura de banco de dados.");
        System.out.println("==========================================================");
        String d;
        String filename = "data.txt";

        List<DataObject> dataObjects = new ArrayList<>();
        List<Integer> k = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            DataObject object = new DataObject();

            List<Abstract> abstractList = new ArrayList<>();
            List<PL> plList = new ArrayList<>();
            List<MH> mHList = new ArrayList<>();
            List<PT> pTList = new ArrayList<>();
            List<PHST> pHSTList = new ArrayList<>();
            List<IS> iSList = new ArrayList<>();
            List<LA> lAtList = new ArrayList<>();
            List<FAU> fAUList = new ArrayList<>();
            List<AID> aIDList = new ArrayList<>();
            List<GR> gRList = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                // Se for uma linha vazia, guarda o objeto populado e prepara um novo
                if (line.isEmpty()) {
                    dataObjects.add(object);
                    object = new DataObject();
                } else { // Se é linha de dados, preenche no objeto atual
                    String[] lineKeyValue = line.split("\t");
                    //object.insertData(lineKeyValue[0], lineKeyValue[1]);
                    if (lineKeyValue[0].equals("AID")) {//dois atributos na classe
                        AID aid = new AID();
                        aid.setAID(lineKeyValue[1]);
                        aIDList.add(aid);
                    }
                    if (lineKeyValue[0].equals("PL")) {
                        PL pl = new PL();
                        pl.setPL(lineKeyValue[1]);
                        plList.add(pl);
                    }
                    if (lineKeyValue[0].equals("FAU")) {
                        FAU fau = new FAU();
                        fau.setFAU(lineKeyValue[1]);
                        fAUList.add(fau);
                    }

                    if (lineKeyValue[0].equals("GR")) {
                        GR gr = new GR();
                        gr.setGR(lineKeyValue[1]);
                    }
                    if (lineKeyValue[0].equals("IS")) {
                        IS is = new IS();
                        is.setIS(lineKeyValue[1]);
                    }

                    if (lineKeyValue[0].equals("LA")) {
                        LA la = new LA();
                        la.setLA(lineKeyValue[1]);
                    }
                    if (lineKeyValue[0].equals("MH")) {
                        MH mh = new MH();
                        mh.setMH(lineKeyValue[1]);
                    }
                    if (lineKeyValue[0].equals("PT")) {
                        PT pt = new PT();
                        pt.setPT(lineKeyValue[1]);
                    }
                    if (lineKeyValue[0].equals("PHST")) {
                        PHST phst = new PHST();
                        phst.setPHST(lineKeyValue[1]);
                    }
                    if (lineKeyValue[0].equals("PMID")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                        Abstract ab = new Abstract();
                        Long i = Long.parseLong(lineKeyValue[1]);
                        ab.setPMID(i);
                    }

                }
            }


            // Essa linha imprimiria todos os objetos processados
            // dataObjects.forEach(System.out::println);
            System.out.println("Total de objetos processados e estruturados: " + dataObjects.size());

            // Salva todos os objetos no banco
            for (DataObject data : dataObjects) {

                data.getValue("PMID");
                abstractRepository.save(new Abstract());
                GRRepository.save(new GR());
                AIDRepository.save(new AID());
                FAURepository.save(new FAU());
                ISRepository.save(new IS());
                LARepository.save(new LA());
                MHRepository.save(new MH());
                PHSTRepository.save(new PHST());
                PLRepository.save(new PL());
                PTRepository.save(new PT());
            }

        } catch (IOException e) {
            System.out.println("Nome de arquivo de entrada inválido.");
            e.printStackTrace();
        }
    }
}
