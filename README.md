# Android Retrofit 


### Code Start 

* Create Model Package -> use Plug-in(Json to Kotlin)

* Create ApiClient Package

     in this pacekage have two file

     * ApiClient
     * ApiInterface 

* ApiClient Class 
-----
```kotlin
  public class ApiClient {
    public var BASE_URL: String = "https://verify.example.com"
    public var retrofit: Retrofit? = null

    public fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
```

* ApiInterface Interface 
-----
```kotlin
interface ApiInterface {

    @GET("api/userlist.php")
   fun getdata(): Call<ArrayList<DATAItem>>

}
```

* MainActivity Class 
-----
```kotlin
// Delcare recyclerView

   var recyclerView: RecyclerView = view.findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(context)

// Set Retrofit

        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getdata().enqueue(object : Callback<ArrayList<DATAItem>> {
            override fun onResponse(call: Call<ArrayList<DATAItem>>?, response: Response<ArrayList<DATAItem>>?) {

//set Your Adapter 
                recyclerView.adapter = myAdapter(response?.body()!!, context)

            }

            override fun onFailure(call: Call<ArrayList<DATAItem>>?, t: Throwable?) {
            }
        })
```


* Adapter Class 
-----
```kotlin 
 class myAdapter(val chats: ArrayList<DATAItem>, val context : Context?):
    RecyclerView.Adapter<myAdapter.Myclass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
    val view=LayoutInflater.from(context).inflate(R.layout.chatlist,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        holder.name.text=chats.get(position).username
        holder.email.text=chats.get(position).email
        Picasso.get().load(chats.get(position).profile).into(holder.profile)
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    class Myclass (v: View):RecyclerView.ViewHolder(v){
        var name=v.findViewById<TextView>(R.id.name)
        var email=v.findViewById<TextView>(R.id.email)
        var profile=v.findViewById<ImageView>(R.id.imageView)
    }
}
```
## Documentation
[Documentation](https://square.github.io/retrofit/)
## Authors
- Nikhil Prajapati
