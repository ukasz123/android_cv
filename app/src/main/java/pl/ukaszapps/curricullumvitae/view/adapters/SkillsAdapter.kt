package pl.ukaszapps.curricullumvitae.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.Skill

class SkillsAdapter(inflater: LayoutInflater) : StateAwareAdapter<Skill>(inflater) {

    override fun onCreateDataViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SkillHolder(inflater.inflate(R.layout.row_skill, parent, false))
    }

    override fun onBindDataViewHolder(holder: RecyclerView.ViewHolder, item: Skill) {
        (holder as SkillHolder).bind(item)
    }


}

private class SkillHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<Skill> {

    private val level: ProgressBar = itemView.findViewById(R.id.skillLevel)
    private val name: TextView = itemView.findViewById(R.id.skillName)
    private val icon: ImageView = itemView.findViewById(R.id.skillIcon)

    override fun bind(value: Skill) {
        Log.d("SkillHolder", "bind: $value")
        level.progress = value.level
        name.text = value.name
        icon.setImageResource(value.icon)
    }

}