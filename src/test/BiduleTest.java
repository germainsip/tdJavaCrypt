package test;

import com.afpa.tools.Transcoder;
import org.germain.tool.ManaBox;
import org.junit.Assert;
import org.junit.Test;

public class BiduleTest {

    @Test
    public void readKeyTest() {
        // La clé cryptée donnée plus haut
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        // La clé décryptée que nous devrions obtenir
        String keyDecrypted = "CFfrkowl.aDzyS:eHjsGPZgMApWvRYVmtnK!BuU IQiEXTxbqhLdNJO,'c";
        // le test d'égalité entre la clé attendue et la sortie de la méthode de la librairie. Si le décryptage ne fonctionne pas nous aurons le message définit ici
        Assert.assertEquals("La librairie de décryptage est mal installée",keyDecrypted, ManaBox.decrypt(keyCrypted));

    }

    @Test
    public void genTranscoder(){
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        Transcoder transcoder = new Transcoder(keyCrypted);
        // on vérifie que l'objet est créé
        Assert.assertNotNull(transcoder);
        // on vérifie que encode est créé
        Assert.assertNotNull(transcoder.getEncode());
        // on affiche encode à l'écran
        System.out.println(transcoder.getEncode().toString());
        // on vérifie que decode est créé
        Assert.assertNotNull(transcoder.getDecode());
        // on affiche decode
        System.out.println(transcoder.getDecode().toString());
    }

}
