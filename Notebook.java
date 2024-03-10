import java.util.Objects;

public class Notebook {
    private double size;
    private String model;
    private String color;
    private String cp;
    private int ram;
    private int hdd;
    private String video;
    private String os;

    public Notebook(double size, String model, String color, String cp, int ram, int hdd, String video, String os) {
        this.size = size;
        this.model = model;
        this.color = color;
        this.cp = cp;
        this.ram = ram;
        this.hdd = hdd;
        this.video = video;
        this.os = os;
    }

    public double getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getCp() {
        return cp;
    }

    public int getRam() {
        return ram;
    }
    
    public int getHdd() {
        return hdd;
    }

    public String getVideo() {
        return video;
    }
    
    public String getOs() {
        return os;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }
    
    public void setVideo(String video) {
        this.video=video;
    }  

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, model, color, cp, ram, hdd, video, os);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null)||(getClass()!=obj.getClass())) return false;
        Notebook note = (Notebook) obj;
        return size==note.size&&model.equals(note.model)&&color.equals(note.color)&&cp.equals(note.cp)&&ram==note.ram&&hdd==note.hdd&&video.equals(note.video)&&os.equals(note.os);
    }

    @Override
    public String toString() {
        return size + "\" Ноутбук " + model + " " + color + "(ЦП "+ cp +", RAM "+ ram + "Гб, HDD "+ hdd + "Гб, " + video + ", " + os + ")";
    }
}