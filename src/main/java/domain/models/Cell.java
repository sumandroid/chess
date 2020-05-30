package domain.models;

public class Cell {

    private String id;
    private Integer coordinateX;
    private Integer coordinateY;

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getId() {
        return id;
    }

    public Cell(Integer coordinateX, Integer coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.id = coordinateX + String.valueOf(coordinateY);
    }
}
