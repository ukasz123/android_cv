package pl.ukaszapps.curricullumvitae.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.OwnProject

class OwnProjectsAdapter(inflater: LayoutInflater) : StateAwareAdapter<OwnProject>(inflater){
    override fun onCreateDataViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return OwnProjectViewHolder(inflater.inflate(R.layout.row_own_project, parent, false))
    }

    override fun onBindDataViewHolder(holder: RecyclerView.ViewHolder, item: OwnProject) {
        (holder as OwnProjectViewHolder).bind(item)
    }
}
private class OwnProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<OwnProject> {
    private val name = itemView.findViewById<TextView>(R.id.projectName)
    private val description = itemView.findViewById<TextView>(R.id.projectDescription)
    private val skillsUsed = itemView.findViewById<ViewGroup>(R.id.projectSkillsUsed)
    override fun bind(value: OwnProject) {
        name.text = value.name
        description.text = value.description
        skillsUsed.removeAllViews()
        value.skillsUsed.forEach {
            skillsUsed.addView(ImageView(skillsUsed.context).apply { setImageResource(it) })
        }
    }

}