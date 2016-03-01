package processor.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class DataObject {

    @Id
    private String id;

    /**
     * Encapsula o mapa multivalorado (mapa de listas).
     * 
     * Um exemplo de mapa contido na variável 'data':
     * 
     * {AttrA=[valor1,valor2,valor3], AttrB=[valorX], AttrC=[ValueA, ValueB]}
     */

    Map<String, List<String>> data = new HashMap<>();

    public void insertData(String key, String value) {
        // Se for uma chave ainda inexistente
        if (data.get(key) == null) {
            List<String> newList = new ArrayList<>();
            newList.add(value);
            data.put(key, newList);
        } else { // Se já existir chave, adiciona na lista já existente
            data.get(key).add(value);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
