package weather_informer_application.bk.wia.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;
import weather_informer_application.bk.wia.R;
import weather_informer_application.bk.wia.entities.other.DatesHelper;
import weather_informer_application.bk.wia.entities.other.MyWeather;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    List<MyWeather> weathers;
    Context ctx;

    PublishSubject<String> infoAboutWeather = PublishSubject.create();

    public PublishSubject<String> getInfoAboutWeather() {
        return infoAboutWeather;
    }



    public WeatherAdapter(List<MyWeather> weathers, Context ctx) {
        this.weathers = weathers;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.weather_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        holder.bind(weathers.get(position));
    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rv_item_date) TextView date;
        @BindView(R.id.rv_item_temp) TextView temp;
        @BindView(R.id.rv_item_image) ImageView image;
        @BindView(R.id.rv_item_description) TextView descr;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        public void bind(MyWeather weather){

            itemView.setOnClickListener(v->{
                getInfoAboutWeather().onNext(weather.getDateTxt());
            });
            DatesHelper dh = new DatesHelper();
            date.setText(weather.getDateTxt());
            temp.setText(String.format("%.1f",weather.getTempC())+"C");
            descr.setText(weather.getDescription());
            Picasso.with(itemView.getContext()).load(weather.getImageURL()).into(image);

        }
    }
}

