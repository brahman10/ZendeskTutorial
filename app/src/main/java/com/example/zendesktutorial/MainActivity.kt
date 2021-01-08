package com.example.zendesktutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import zendesk.core.AnonymousIdentity
import zendesk.core.Identity
import zendesk.core.Zendesk
import zendesk.support.Support
import zendesk.support.requestlist.RequestListActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Zendesk.INSTANCE.init(this, "support@yashacropolisglobal.zendesk.com", "appId", "clientId")

        Zendesk.INSTANCE.init(this, "https://yashacropolisglobal.zendesk.com",
            "f93aee8bd5e7bb4be7821960ae97cf96e3cad2c467ea8d3f",
            "mobile_sdk_client_bed98502a5a38635dda1")

        Support.INSTANCE.init(Zendesk.INSTANCE)
        val identity: Identity = AnonymousIdentity()
        Zendesk.INSTANCE.setIdentity(identity)
        Support.INSTANCE.init(Zendesk.INSTANCE)

        RequestListActivity.builder()
                .show(this)
        /*showticket.setOnClickListener{


        }

        createticket.setOnClickListener{
            RequestActivity.builder()
                    .withRequestSubject("Testing Support SDK")
                    .withTags("sdk", "android")
                    .show(this);
        }
        help.setOnClickListener{
            HelpCenterActivity.builder()
                    .show(this)
        }
        article.setOnClickListener{
            ViewArticleActivity.builder()
                    .show(this)
        }*/
    }
}