package com.example.naverkin


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.naverkin.databinding.PraticeBinding

class PracticeListAdapter: ListAdapter<Test,PracticeListAdapter.ViewHolder>(DiffToll()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding= PraticeBinding.inflate(layoutInflater)//메모리 지금 올라감
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding:PraticeBinding):RecyclerView.ViewHolder(binding.root) {

        //데이터 바인딩 하면 뷰랑 데이터랑 전부 추적해줌!!
        fun bind(test:Test){
            binding.item = test
        }


    }

    private class DiffToll:DiffUtil.ItemCallback<Test>(){
        //아이템 다른지 안다른지 해주기 위해서 사용
        override fun areItemsTheSame(oldItem: Test, newItem: Test): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Test, newItem: Test): Boolean {
           return oldItem==newItem
        }

    }
}
data class Test(
    val id:String,
    val name:String
)

// activity 에서  val adpater = PracticeListAapter()
//adpater.submitList(여기안에는 리스트를 넣어줌)