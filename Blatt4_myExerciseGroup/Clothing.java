class Clothing{
    private String category;
    private String color;
    private String size;

    public Clothing(String category, String color, String size){
        this.category = category;
        this.color = color;
        this.size = size;
    }

    public String getCategory(){
        return this.category;
    }

    public String getColor(){
        return this.color;
    }

    public String getSize(){
        return this.size;
    }

    public void changeSize(String size){
        this.size = size;
    }

    public void Print(){
        System.out.println(this.category);
        System.out.println(this.color);
        System.out.println(this.size);
    }
}