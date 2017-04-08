package learnapi.immindie.moodiie.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SoundCloundNetwork {

    private static SoundCloundNetwork network;
    private SoundCloundAPI api;

    private SoundCloundNetwork() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.soundcloud.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(SoundCloundAPI.class);
    }

    public static SoundCloundNetwork getInstance() {
        if (network == null) {
            network = new SoundCloundNetwork();
        }
        return network;
    }

    public SoundCloundAPI getApi() {
        return api;
    }
}
