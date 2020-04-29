package com.example.myapplication.mock;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class MockHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private String mIDd;

    public MockHolder(@NonNull View itemView) {
        super(itemView);

        mName = itemView.findViewById(R.id.menu_name);
    }

    public void bind(Mock mock) {
        mName.setText(mock.getmName());
        mIDd = mock.getmValue();
    }

    public void setListener(final MockAdapter.OnItemClickListener mListener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(mIDd);
            }
        });
    }
}
