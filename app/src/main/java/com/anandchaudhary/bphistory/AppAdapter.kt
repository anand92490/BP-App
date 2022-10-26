package com.anandchaudhary.bphistory

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class AppAdapter(private var readings: MutableList<BloodPressure>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder> (){

    class AppViewHolder(inflater : LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_layout, parent, false)){

        private lateinit var bp: BloodPressure

        init {
            itemView.setOnClickListener {
                Snackbar.make(it, bp.toString(), Snackbar.LENGTH_SHORT).show()
            }
        }

            fun bind(bp: BloodPressure){
                this.bp = bp
                val textReading : TextView = itemView.findViewById(R.id.text_reading)
                val textDate : TextView = itemView.findViewById(R.id.text_date)
                textReading.text =
                    "${bp.systolic}/${bp.diastolic} - ${BloodPressure.categories[bp.category()]}"
                textDate.text = bp.date.toString()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AppViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(readings[position])
    }

    override fun getItemCount() = readings.size

}