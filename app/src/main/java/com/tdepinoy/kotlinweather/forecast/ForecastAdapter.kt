package com.tdepinoy.kotlinweather.forecast

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.tdepinoy.kotlinweather.core.model.ForecastItem

class ForecastAdapter(val items: List<ForecastItem>) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].weather[0].description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}