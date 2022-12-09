package StackTrace.VirtualWallet;

import java.util.List;

import StackTrace.VirtualWallet.Billetera.Billetera;
import StackTrace.VirtualWallet.Usuario.Usuario;

public class UsuarioBilletera {
    public Usuario usuario;
    public List<Billetera> billeteras;

    public UsuarioBilletera(Usuario usuario,List<Billetera> billeteras){
        this.usuario = usuario;
        this.billeteras = billeteras;
    }
}
