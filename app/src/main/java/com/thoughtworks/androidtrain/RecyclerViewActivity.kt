package com.thoughtworks.androidtrain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.thoughtworks.androidtrain.data.Tweet
import com.thoughtworks.androidtrain.utils.adapters.MainAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    val items = listOf(
        "给初学者的RxJava2.0教程（七）: Flowable",
        "Android之View的诞生之谜",
        "Android之自定义View的死亡三部曲之Measure",
        "Using ThreadPoolExecutor in Android ",
        "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
        "Android异步的姿势，你真的用对了吗？",
        "Android 高质量录音库。",
        "Android 边缘侧滑效果，支持多种场景下的侧滑退出。"
    )

    private var personAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        InitUi()
    }

    private fun InitUi(){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = layoutManager
        personAdapter = MainAdapter()
        personAdapter!!.setTweet(createTweet())
        recycler_view.adapter = personAdapter
    }

    private fun createTweet(): ArrayList<Tweet> {
        val type = object : TypeToken<ArrayList<Tweet>>(){}.type
        val tweet_data = Gson().fromJson<ArrayList<Tweet>>(tweet_data,type)
        val mIterator = tweet_data.iterator()
        while (mIterator.hasNext()) {
            val next = mIterator.next()
            if (next.error != null || next.unknownError != null) {
                mIterator.remove()
            }
        }

        return tweet_data
    }

    val tweet_data = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"content\": \"沙发！\",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/001.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/002.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/003.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"cyao\",\n" +
            "      \"nick\": \"Cheng Yao\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/001.jpeg\"\n" +
            "    },\n" +
            "    \"comments\": [\n" +
            "      {\n" +
            "        \"content\": \"Good.\",\n" +
            "        \"sender\": {\n" +
            "          \"username\": \"leihuang\",\n" +
            "          \"nick\": \"Lei Huang\",\n" +
            "          \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/002.jpeg\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"content\": \"Like it too\",\n" +
            "        \"sender\": {\n" +
            "          \"username\": \"weidong\",\n" +
            "          \"nick\": \"WeiDong Gu\",\n" +
            "          \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/003.jpeg\"\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"xinge\",\n" +
            "      \"nick\": \"Xin Ge\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/000.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/004.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"yangluo\",\n" +
            "      \"nick\": \"Yang Luo\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/004.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/005.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"jianing\",\n" +
            "      \"nick\": \"Jianing Zheng\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/005.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"error\": \"losted\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"content\": \"Unlike many proprietary big data processing platform different, Spark is built on a unified abstract RDD, making it possible to deal with different ways consistent with large data processing scenarios, including MapReduce, Streaming, SQL, Machine Learning and Graph so on. To understand the Spark, you have to understand the RDD. \",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/006.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"weifan\",\n" +
            "      \"nick\": \"Wei Fan\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/006.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"content\": \"这是第二页第一条\",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/007.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/008.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/009.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/010.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"xinguo\",\n" +
            "      \"nick\": \"Xin Guo\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/007.jpeg\"\n" +
            "    },\n" +
            "    \"comments\": [\n" +
            "      {\n" +
            "        \"content\": \"Good.\",\n" +
            "        \"sender\": {\n" +
            "          \"username\": \"yanzili\",\n" +
            "          \"nick\": \"Yanzi Li\",\n" +
            "          \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/008.jpeg\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"content\": \"Like it too\",\n" +
            "        \"sender\": {\n" +
            "          \"username\": \"jingzhao\",\n" +
            "          \"nick\": \"Jing Zhao\",\n" +
            "          \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/001.jpeg\"\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"hengzeng\",\n" +
            "      \"nick\": \"Niang Niang\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/000.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/011.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"jizhang\",\n" +
            "      \"nick\": \"Jian Zhang\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/002.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 10,\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/012.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"yanzi\",\n" +
            "      \"nick\": \"Yanzi Li\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/003.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 11,\n" +
            "    \"error\": \"illegal\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 12,\n" +
            "    \"error\": \"MISS\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 13,\n" +
            "    \"error\": \"WOW\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 14,\n" +
            "    \"content\": \"As a programmer, we should as far as possible away from the Windows system. However, the most a professional programmer, and very difficult to bypass Windows this wretched existence but in fact very real, then how to quickly build a simple set of available windows based test environment? See Qiu Juntao's blog. \",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/013.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"jianing\",\n" +
            "      \"nick\": \"Jianing Zheng\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/004.jpeg\"\n" +
            "    },\n" +
            "    \"comments\": [\n" +
            "      {\n" +
            "        \"content\": \"Good.\",\n" +
            "        \"sender\": {\n" +
            "          \"username\": \"cyao\",\n" +
            "          \"nick\": \"Cheng Yao\",\n" +
            "          \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/005.jpeg\"\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 15,\n" +
            "    \"content\": \"第9条！\",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/014.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/015.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/016.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/016.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/017.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/018.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/019.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/020.jpeg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/tweets/021.jpeg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"jianing\",\n" +
            "      \"nick\": \"Jianing Zheng\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/006.jpeg\"\n" +
            "    },\n" +
            "    \"comments\": []\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 16,\n" +
            "    \"content\": \"第10条！\",\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"xinguo\",\n" +
            "      \"nick\": \"Xin Guo\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/007.jpeg\"\n" +
            "    },\n" +
            "    \"comments\": []\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 17,\n" +
            "    \"content\": \"楼下保持队形，第11条\",\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"yanzi\",\n" +
            "      \"nick\": \"Yanzi Li\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/008.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 18,\n" +
            "    \"content\": \"第12条\",\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"xinguo\",\n" +
            "      \"nick\": \"Xin Guo\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/001.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 19,\n" +
            "    \"content\": \"第13条\",\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"yanzili\",\n" +
            "      \"nick\": \"Yanzi Li\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/002.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 20,\n" +
            "    \"content\": \"第14条\",\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"xinguo\",\n" +
            "      \"nick\": \"Xin Guo\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/003.jpeg\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 21,\n" +
            "    \"unknown error\": \"STARCRAFT2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 22,\n" +
            "    \"content\": \"- The data json will be hosted in http://thoughtworks-ios.herokuapp.com/- Nibs or storyboards are prohibited- Implement cache mechanism by you own if needed- Unit tests is appreciated.- Functional programming is appreciated- Deployment Target should be 7.0- Utilise Git for source control, for git log is the directly evidence of the development process- Utilise GCD for multi-thread operation- Only binary, framework or cocopods dependency is allowed. do not copy other developer's source code(*.h, *.m) into your project- Keep your code clean as much as possible\",\n" +
            "    \"sender\": {\n" +
            "      \"username\": \"hengzeng\",\n" +
            "      \"nick\": \"Huan Huan\",\n" +
            "      \"avatar\": \"https://thoughtworks-mobile-2018.herokuapp.com/images/user/avatar/004.jpeg\"\n" +
            "    }\n" +
            "  }\n" +
            "]"


}