package layout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbn.movil.R;

import butterknife.ButterKnife;


public class RegisterFragment extends DialogFragment {
    RegisterListener listener;

    public interface RegisterListener { //se habilita la interfaz
        void onOkClick();
    }


    @Override
    public void onAttach(Context context) { //se crea el onattach
        super.onAttach(context);
        if (context instanceof RegisterListener){
            listener = (RegisterListener) context;
        } else
            throw new IllegalStateException(" interface no generada ");
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_register, null);//esto es importante.... pone el dialog flotante
        ButterKnife.bind(this, view);

        AlertDialog.Builder registerDialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Registro exitoso")
                .setNegativeButton("Cancelar", null)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onOkClick();
                    }
                });
        return registerDialog.create();
    }
}
