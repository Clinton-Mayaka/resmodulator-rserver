package ViewHolder;

import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.resmodulatorserver.R;

import Interface.ItemClickListener;
import info.hoang8f.widget.FButton;

public class OrderViewHolder extends RecyclerView.ViewHolder {

    public TextView txtOrderId,txtOrderStatus,txtTableNo,txtOrderPhone,txtOrderDate;

    public Button btnEdit,btnRemove,btnDetails;




    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txtOrderPhone = (TextView)itemView.findViewById(R.id.order_phone_number);
        txtOrderId = (TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus = (TextView)itemView.findViewById(R.id.order_status);
        txtTableNo = (TextView)itemView.findViewById(R.id.order_TableNo);
        txtOrderDate = (TextView)itemView.findViewById(R.id.order_date);

        btnEdit = (FButton)itemView.findViewById(R.id.btnEdit);
        btnRemove = (FButton)itemView.findViewById(R.id.btnRemove);
        btnDetails = (FButton)itemView.findViewById(R.id.btnDetails);



    }

}
