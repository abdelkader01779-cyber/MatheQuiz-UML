public class Questions {
    private String fragestellung;
    private String[]  antworten;
    private String bildPfad;
    private int korrekterIndex;
    public Questions(String fragestellung,String[] antworten , int korrekterIndex,String bildPfad){
        this.fragestellung=fragestellung;
        this.antworten=antworten;
        this.korrekterIndex=korrekterIndex;
        this.bildPfad=bildPfad;
    }
    public String getFragestellung(){
        return fragestellung;
    }
    public String[] getAntworten(){
        return antworten;
    }

    public int getKorrekterIndex() {
        return korrekterIndex;
    }
    public boolean istRichtig(int chosedIndex){
        return chosedIndex==korrekterIndex;
    }
}
