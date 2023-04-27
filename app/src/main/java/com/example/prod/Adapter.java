package com.example.prod;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.triplezero.xui.databinding.TaskMainBinding;
import com.triplezero.xui.databinding.SubtaskCardBinding;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<ListEntity> data; // данные для вывода в список
    private final LayoutInflater localInflater; // "раздуватель" с контекстом

    public Adapter(Context context, List<ListEntity> data) {
        this.data = data;
        this.localInflater = LayoutInflater.from(context);
    }


    // Создание вьюхолдера из разметки
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
        @NonNull ViewGroup parent,
        int viewType
    ) {

        TaskMainBinding binding = TaskMainBinding.inflate(localInflater, parent, false);
        //SubtaskCardBinding stBinding = SubtaskCardBinding.inflate(localInflater, parent, false);
        return new ViewHolder(binding); //stBinding
    }

    // Выставляет значения из списка данных во вьюхи по номеру элемента списка
    @Override
    public void onBindViewHolder(
        @NonNull ViewHolder holder,
        int position
    ) {
        ListEntity item = data.get(position);
        holder.taskName.setText(item.GettaskName());
        holder.subtaskName.setText(item.GetSubtaskName());
        holder.subtaskText.setText(item.GetSubtaskText());
    }

    // Возвращает размер списка данных, нужно для внутренней работы ресайклера
    @Override
    public int getItemCount() {
        return data.size();
    }

    // Хранит переменные вьюх в разметке элементов списка
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        TextView subtaskName;
        TextView subtaskText;
        public ViewHolder(@NonNull TaskMainBinding binding ) { //@NonNull SubtaskCardBinding stBinding
            super(binding.getRoot());
            taskName = binding.taskName;
            //stBinding.getRoot();
            subtaskName = binding.subtaskName;
            subtaskText = binding.subtaskText;
        }
    }
}
