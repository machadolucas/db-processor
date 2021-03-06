package processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import processor.db.DataObjectRepository;
import processor.entity.DataObject;

@Component
public class Processor {

    @Autowired
    private DataObjectRepository repository;

    @PostConstruct
    public void init() {
        System.out.println("==========================================================");
        System.out.println("Processador de texto para uma estrutura de banco de dados.");
        System.out.println("==========================================================");

        String filename = "data.txt";

        List<DataObject> dataObjects = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            DataObject object = new DataObject();

            String line;
            while ((line = br.readLine()) != null) {
                // Se for uma linha vazia, guarda o objeto populado e prepara um novo
                if (line.isEmpty()) {
                    dataObjects.add(object);
                    object = new DataObject();
                } else { // Se é linha de dados, preenche no objeto atual
                    String[] lineKeyValue = line.split("\t");
                    object.insertData(lineKeyValue[0], lineKeyValue[1]);
                }
            }

            // Essa linha imprimiria todos os objetos processados
            // dataObjects.forEach(System.out::println);

            System.out.println("Total de objetos processados e estruturados: " + dataObjects.size());

            // Salva todos os objetos no banco
            for (DataObject data : dataObjects) {
                repository.save(data);
            }

        } catch (IOException e) {
            System.out.println("Nome de arquivo de entrada inválido.");
            e.printStackTrace();
        }
    }
}
