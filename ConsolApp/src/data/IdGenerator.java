package data;

import tools.WrongInputException;

import java.util.HashMap;

public class IdGenerator {
    private HashMap<Long, Boolean> occupiedId = new HashMap<>();
    private Long overallId = 0L;

    public boolean checkId(Long id){
        return (occupiedId.get(id) == null ? false : occupiedId.get(id));
    }

    public void setId(Long id){
        if (!checkId(id)){
            occupiedId.put(id, true);
            if (id > overallId) {
                overallId = id;
            }
        } else {
            throw new WrongInputException(id + " is already occupied");
        }
    }

    public Long getNewId(){
        overallId++;
        return overallId;
    }
}
