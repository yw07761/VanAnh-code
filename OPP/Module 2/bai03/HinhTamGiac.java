package hoHoangVanAnh.bai03;
public class HinhTamGiac
{
    private float ma;
    private float mb;
    private float mc;

    public HinhTamGiac(float ma, float mb, float mc)
    {
        boolean khongLaHinhTamGiac = (ma + mb <= mc || ma + mc <= mb || mb + mc <= ma);
        if (ma <= 0 || mb <= 0 || mc <= 0 || khongLaHinhTamGiac)
        {
            this.ma = 0f;
            this.mb = 0f;
            this.mc = 0f;
        }
        else
        {
            this.ma = ma;
            this.mb = mb;
            this.mc = mc;
        }
        
    }

    public HinhTamGiac()
    {
        ma = 0f;
        mb = 0f;
        mc = 0f;
    }

    public float getMA()
    {
        return ma;
    }
    
    public void setMA(float ma)
    {
        boolean khongLaHinhTamGiac = (ma + this.mb <= this.mc || ma + this.mc <= this.mb || this.mb + this.mc <= ma);

        if (ma <= 0 || khongLaHinhTamGiac)
        {
        }
        else    
        {
            this.ma = ma;
        }
    }
    
    public float getMB()
    {
        return mb;
    }
    
    public void setMB(float mb)
    {
        boolean khongLaHinhTamGiac = (this.ma + mb <= this.mc || this.ma + this.mc <= mb || mb + this.mc <= this.ma);

        if (mb <= 0 || khongLaHinhTamGiac)
        {
        }
        else    
        {
            this.mb = mb;
        }
    }

    public float getMC()
    {
        return mc;
    }
    
    public void setMC(float mc)
    {
        boolean khongLaHinhTamGiac = (this.ma + this.mb <= mc || this.ma + mc <= this.mb || this.mb + mc <= this.ma);

        if (mc <= 0 || khongLaHinhTamGiac)
        {
        }
        else    
        {
            this.mc = mc;
        }
    }

    public float chuVi()
    {
        return ma + mb + mc;
    }

    public double dienTich()
    {
        double p = (ma + mc + mc)/2.0f;

        return Math.sqrt(p * (p - ma) * (p - mb) * (p - mc));
    }

    public String kieuTamGiac()
    {
    	// kiểm tra kiểu tam giác 
        boolean Deu = (ma == mb && ma == mc);
        boolean Can = (ma == mb || ma == mc || mb == mc);
        boolean Vuong = (ma*ma + mb*mb == mc*mc || ma*ma + mc*mc == mb*mb || mb*mb + mc*mc == ma*ma);
        boolean Error = (ma + mb <= mc || ma + mc <= mb || mb + mc <= ma);

        if (Error)
            return "Khong phai tam giac";
        else
        if (Deu)
            return "Tam gia deu";
        else if (Vuong && Can)
            return "Tam giac vuong can";
        else if (Can)
            return "Tam giac can";
        else if (Vuong)
            return "Tam giac vuong";
        else 
            return "Tam giac thuong";
    }

    @Override
    public String toString()
    {
        return String.format("%-10.2f %-10.2f %-10.2f %-20s %-10.2f %-10.2f", 
            ma, mb, mc, kieuTamGiac(), chuVi(), dienTich());
    }
}