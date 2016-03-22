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
    private GRRepository gRRepository ;

    @Autowired
    private AIDRepository aIDRepository ;

    @Autowired
    private AbstractRepository abstractRepository;

    @Autowired
    private FAURepository fAURepository;

    @Autowired
    private LARepository lARepository;

    @Autowired
    private MHRepository mHRepository;

    @Autowired
    private PLRepository pLRepository;

    @Autowired
    private ISRepository iSRepository;
    @Autowired
    private PTRepository pTRepository;

    @Autowired
    private PHSTRepository pHSTRepository;


    @PostConstruct
    public void init() {
        System.out.println("==========================================================");
        System.out.println("Processador de texto para uma estrutura de banco de dados.");
        System.out.println("==========================================================");
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



            while ((line = br.readLine()) != null)
                // Se for uma linha vazia, guarda o objeto populado e prepara um novo
                if (line.isEmpty()) {
                    dataObjects.add(object);
                    object = new DataObject();
                } else { // Se é linha de dados, preenche no objeto atual
                    String[] lineKeyValue = line.split("\t");
                    //object.insertData(lineKeyValue[0], lineKeyValue[1]);
                    Abstract ab = new Abstract();
                    while(!line.isEmpty()) {
                        if (lineKeyValue[0].equals("PMID")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            Long i = Long.parseLong(lineKeyValue[1]);
                            ab.setPMID(i);
                        }
                        if (lineKeyValue[0].equals("OWN")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setOWN(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("STAT")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setSTAT(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("DA")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setDA(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("VI")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setVI(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("IP")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setIP(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("DP")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setDP(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("TI")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setTI(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("PG")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setPG(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("AB")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setAB(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("TA")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setTA(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("JT")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setJT(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("AID")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setAID(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("SB")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setSB(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("AD")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setAD(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("PST")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setPST(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("SO")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setSO(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("PL")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setPL(lineKeyValue[1]);
                        }
                        if (lineKeyValue[0].equals("LA")) {// aqui estou com duvida, essa classe tem varios atributos, como irei salvar na lista?
                            ab.setLA(lineKeyValue[1]);
                        }
                    }
                    abstractList.add(ab);
            }


            // Essa linha imprimiria todos os objetos processados
            // dataObjects.forEach(System.out::println);
            //System.out.println("Total de objetos processados e estruturados: " + dataObjects.size());

            // Salva todos os objetos no banco
            for (Abstract data : abstractList) {

                abstractRepository.save(data);
               /*GRRepository.save(new GR());
                AIDRepository.save(new AID());
                FAURepository.save(new FAU());
                ISRepository.save(new IS());
                LARepository.save(new LA());
                MHRepository.save(new MH());
                PHSTRepository.save(new PHST());
                PTRepository.save(new PT());*/
                //pLRepository.save(new PL(data));

            }

        } catch (IOException e) {
            System.out.println("Nome de arquivo de entrada inválido.");
            e.printStackTrace();
        }
    }
}

 /*enquanto (line = br.readLine() !=null)
                    enquanto !line.isEmpty()

                        while(!line.isEmpty()) {
                            if (lineKeyValue[0].equals("AID")) {//dois atributos na classe
                        AID aid = new AID();
                        aid.setAID(lineKeyValue[1]);
                        aIDList.add(aid);
                    }
                     if (lineKeyValue[0].equals("PMID")) {
                        Abstact ab = new Abstract();
                        pl.setPL(lineKeyValue[1]);
                        plList.add(pl);

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
                        phst.setPHST(lineKeyValue[1]);*/