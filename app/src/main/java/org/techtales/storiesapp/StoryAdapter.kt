package org.techtales.storiesapp

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class StoryAdapter (private val storyList:List<StoryModel>, private val clickListener:(StoryModel)->Unit):RecyclerView.Adapter<MyviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val storyItem = layoutInflater.inflate(R.layout.stories_item, parent, false)
        return MyviewHolder(storyItem)
    }

    override fun getItemCount(): Int {
        return storyList.size

    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val story = storyList[position]
        holder.bind(story,clickListener)

    }


}

class MyviewHolder(val view:View):RecyclerView.ViewHolder(view) {
    fun bind(story:StoryModel, clickListener: (StoryModel) -> Unit){
        val title = view.findViewById<TextView>(R.id.title)
        val details = view.findViewById<TextView>(R.id.storyDetail)
        val img = view.findViewById<CircleImageView>(R.id.story1)

        title.text = story.title
        details.text = story.details.toString()
        img.setImageResource(story.img)

        view.setOnClickListener{
            clickListener(story)
        }

    }

}
