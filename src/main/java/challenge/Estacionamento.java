package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    final int SENIOR = 55;
    final int LOTACAO_MAXIMA=10;
    final int IDADE_MINIMA=18;
    final int PONTUACAO_MAXIMA=20;

    List<Carro> estacionados = new ArrayList<>();


    public void estacionar(Carro carro) {
        if(carro.getMotorista().getIdade() >= IDADE_MINIMA && carro.getMotorista().getPontos() <= PONTUACAO_MAXIMA ){
            if(estacionados.size() == LOTACAO_MAXIMA){
                Carro removido = estacionados.stream()
                        .filter(item -> item.getMotorista().getIdade() < SENIOR).findFirst()
                        .orElseThrow(() -> new EstacionamentoException("Nao ha vagas"));
                estacionados.remove(removido);
            }
            estacionados.add(carro);
        }else{
            throw new EstacionamentoException("Motorista precisa ser maior de idade e não possuir habilitação suspensa!");
        }
    }

    public int carrosEstacionados() {

        return estacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {

        return estacionados.contains(carro);
    }
}
