package pl.ukaszapps.curricullumvitae.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.Loading
import pl.ukaszapps.curricullumvitae.view.model.ResultState
import pl.ukaszapps.curricullumvitae.view.model.Value
import pl.ukaszapps.curricullumvitae.view.model.Error

interface Bindable<T> {
    fun bind(value: T)
}

abstract class StateAwareAdapter<T>(protected val inflater: LayoutInflater) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Observer<ResultState<List<T>>> {

    var state: ResultState<List<T>> = Loading()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("StateAwareAdapter", "onCreateViewHolder: $viewType")
        return when (viewType) {
            R.layout.row_error -> ErrorViewHolder(
                inflater.inflate(
                    R.layout.row_error,
                    parent,
                    false
                )
            )
            R.layout.row_loading_indicator -> LoadingViewHolder(
                inflater.inflate(
                    R.layout.row_loading_indicator,
                    parent,
                    false
                )
            )
            else -> onCreateDataViewHolder(parent, viewType)
        }
    }

    abstract fun onCreateDataViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder


    override fun getItemCount(): Int =
        when (val current = state) {
            is Value -> current.value.size
            else -> 1
        }

    override fun getItemViewType(position: Int): Int =
        when (state) {
            is Loading -> R.layout.row_loading_indicator
            is Error -> R.layout.row_error
            else -> getDataItemViewType(position)
        }


    open fun getDataItemViewType(position: Int) = 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LoadingViewHolder -> {
            }
            is ErrorViewHolder -> holder.bind((state as Error).errorMessage)
            else -> onBindDataViewHolder(holder, (state as Value).value[position])
        }
    }

    open fun onBindDataViewHolder(holder: RecyclerView.ViewHolder, item: T) {

    }

    override fun onChanged(t: ResultState<List<T>>?) {
        state = t ?: Loading()
    }

}

class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view)

class ErrorViewHolder(view: View) : RecyclerView.ViewHolder(view), Bindable<String> {
    private val errorMessageView = view.findViewById<TextView>(R.id.error_message)

    override fun bind(value: String) {
        errorMessageView.text = value
    }


}
