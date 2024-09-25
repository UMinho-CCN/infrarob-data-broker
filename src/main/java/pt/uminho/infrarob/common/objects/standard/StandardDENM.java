package pt.uminho.infrarob.common.objects.standard;

public class StandardDENM {
    private DENMHeader header;
    private DenmBody denm;

    public StandardDENM() {
    }

    public StandardDENM(DENMHeader header, DenmBody denm) {
        this.header = header;
        this.denm = denm;
    }

    public DENMHeader getHeader() {
        return header;
    }

    public void setHeader(DENMHeader header) {
        this.header = header;
    }

    public DenmBody getDenm() {
        return denm;
    }

    public void setDenm(DenmBody denm) {
        this.denm = denm;
    }

    @Override
    public String toString() {
        return "StandardDENM{" +
                "header=" + header +
                ", denm=" + denm +
                '}';
    }
}
